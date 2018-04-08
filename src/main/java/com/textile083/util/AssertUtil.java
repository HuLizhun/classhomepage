package com.textile083.util;

import com.textile083.exception.AssertException;

public class AssertUtil {

	/**
	 *  不为空验证
	 * @param message
	 * @param target
	 * @return
	 */
    public static String assertNotBlank(String message,String target) throws Exception{
        if(target==null||(target=target.trim()).length()==0){
            throw new AssertException(message);
        }
        return target;
    }
    
    /**
     * 不一致验证
     * @param message
     * @param a
     * @param b
     */
    public static Object assertNotEquals(String message,Object a,Object b) throws Exception{
    	if(a==null?a!=b:!a.equals(b)){
    		throw new AssertException(message);
    	}
    	return b;
    }
}
