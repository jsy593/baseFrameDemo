package com.jsy.cn.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.javassist.ClassClassPath;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.Modifier;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsy.cn.annotation.SystemLog;

/**
 * 切面测试
 * @Title: SystemLogAspect.java 
 * @Description: TODO
 * @author shunyan.jia
 * @date 2017年11月8日
 */
@Aspect
@Component
public class SystemLogAspect {
	private  Logger logger = Logger.getLogger(SystemLogAspect.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	/**
	 * 定义在controller包和所有子包里的任意类的任意方法的执行
	 */
	@Pointcut("execution(* com.jsy.cn.controller..*.*(..))")
	public void controllerAspect(){
	}
	
	@Before("controllerAspect()")
	public void beforeAspect(JoinPoint joinPoint){
		logger.info("进入方法前：---------");
		logger.info(joinPoint.getClass().getName());
		logger.info(Arrays.toString(joinPoint.getTarget().getClass().getMethods()));
	}
	
	@Around("controllerAspect()")
	public Object arountAspect(ProceedingJoinPoint joinPoint) throws Throwable{
		logger.info("进入方法：");
		String targetName =joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Class<?> clazz = Class.forName(targetName);
		Method[] methods = clazz.getMethods();
		for(Method method: methods){
			if(method.getName().equals(methodName)){
				SystemLog systemLog = method.getAnnotation(SystemLog.class);
				Class<? extends Annotation> annotationType = systemLog.annotationType();
				System.out.println(annotationType.getName());
				String desc = systemLog.operationdesc();
				String type = systemLog.operationType();
				logger.info("desc:"+desc);
				logger.info("type:"+type);
				break;
			}
		}
		Object[] args = joinPoint.getArgs();
		Map<String,Object>  map = SystemLogAspect.getFieldsName(clazz,clazz.getName(),methodName,args);
		logger.info(mapper.writeValueAsString(map));
		Object result = joinPoint.proceed();
		
		Object json = mapper.writeValueAsString(result);
		logger.info(json.toString());
		return result;
	}

	private static Map<String,Object> getFieldsName(Class<?> cls, String clazzName, String methodName, Object[] args) throws Exception {   
        Map<String,Object > map=new HashMap<String,Object>(); 
        
        ClassPool pool = ClassPool.getDefault();    
        ClassClassPath classPath = new ClassClassPath(cls);    
        pool.insertClassPath(classPath);    
        CtClass cc = pool.get(clazzName);    
        CtMethod cm = cc.getDeclaredMethod(methodName);    
        MethodInfo methodInfo = cm.getMethodInfo();  
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();    
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);    
        if (attr != null) {    
        	int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;    
        	for (int i = 0; i < cm.getParameterTypes().length; i++){    
        		map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名    
        	}    
        }    
        return map;    
    }    
}
