/***********************************************************************
 * Module:  SearchOption.java
 * Author:  saul
 * Purpose: Defines the Class SearchOption
 ***********************************************************************/

package com.fangda.skylot.mathine.utils;

import java.util.*;

/** @pdOid da00d6de-302d-4271-9a3d-3e774d305a9e */
public class SearchOption {
   /** 操作方式，默认不传递
    * 
    * 
    * @pdOid 19f6b582-bae7-4149-bad1-ba280724cf32 */
   private String op;
   /** 搜索条件组合对象
    * 
    * 
    * @pdOid a317b52d-5fd8-4a0f-b557-644207b34afa */
   private List<SearchField> rules;
   
   /** @return the op
    * 
    * @pdOid 4b193c78-1b2c-499a-ae24-f9c1753fb1d5 */
   public String getOp() {
   	return op;
   }
   
   /** @param op the op to set
    * @pdOid 3ca54969-958d-4642-9d78-105a7f08c553 */
   public void setOp(String op) {
   	this.op = op;
   }
   
   /** @return the rules
    * 
    * @pdOid 074a7e40-e08e-4819-abf3-95136b81a568 */
   public List<SearchField> getRules() {
   	return rules;
   }
   
   /** @param rules the rules to set
    * @pdOid 7a6dd932-03ba-4a27-a22f-5602e42e3e6d */
   public void setRules(List<SearchField> rules) {
   	this.rules = rules;
   }

}