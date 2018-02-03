/***********************************************************************
 * Module:  SearchField.java
 * Author:  saul
 * Purpose: Defines the Class SearchField
 ***********************************************************************/

package com.fangda.skylot.mathine.utils;

import java.util.*;

/** @pdOid d9c2503e-4a45-4726-bda0-390763b02f2b */
public class SearchField {
   /** 操作类型 like，greaterorequal，lessorequal，equal，in
    * 
    * 
    * @pdOid 2a17f030-ef11-41af-9ad1-1c0ae991eeac */
   private String op;
   /** 待搜索的字段
    * 
    * 
    * @pdOid 44219d49-fb05-44b0-bbec-d1e23d00fccc */
   private String field;
   /** 传人的搜索值
    * 
    * 
    * @pdOid 1e8ff356-f087-4b69-aba0-0017f94d6499 */
   private String value;
   /** 对象类型 int，String
    * 
    * 
    * @pdOid 0b57b4a6-4768-40fd-a512-a3a7c7702649 */
   private String type;
   
   /** @return the op
    * 
    * @pdOid 674e5aab-03e1-411e-8224-825ee0a92eef */
   public String getOp() {
   	return op;
   }
   
   /** @param op the op to set
    * @pdOid ed083a7e-3ebd-462d-8cef-4c818862747e */
   public void setOp(String op) {
   	this.op = op;
   }
   
   /** @return the field
    * 
    * @pdOid f8a9ccc3-2793-475f-a301-96e093babe2c */
   public String getField() {
   	return field;
   }
   
   /** @param field the field to set
    * @pdOid 59fb5b91-d53b-453b-bdab-44d3864e79db */
   public void setField(String field) {
   	this.field = field;
   }
   
   /** @return the value
    * 
    * @pdOid 7a4fb886-3a55-4718-a90e-a8af164c6f4e */
   public String getValue() {
   	return value;
   }
   
   /** @param value the value to set
    * @pdOid a54707a9-70ae-4464-b174-ad5752059471 */
   public void setValue(String value) {
   	this.value = value;
   }
   
   /** @return the type
    * 
    * @pdOid 017d3c91-0a28-45fe-8540-83f9be2190a4 */
   public String getType() {
   	return type;
   }
   
   /** @param type the type to set
    * @pdOid ae07cbed-9bd5-491f-8fa2-3d140cdce2e7 */
   public void setType(String type) {
   	this.type = type;
   }

}