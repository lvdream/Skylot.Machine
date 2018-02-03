/***********************************************************************
 * Module:  SkyLotException.java
 * Author:  saul
 * Purpose: Defines the Class SkyLotException
 ***********************************************************************/

package com.fangda.skylot.mathine.utils.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目默认异常控制
 *
 * @pdOid a64a15be-bff7-46ee-a296-26bfa437ff2b
 */
@Slf4j
@Data
public class SkyLotException extends Exception {
    /**
     * @pdOid d9f63a2e-ca4f-4551-8500-7d968113318c
     */
    private static final long serialVersionUID = 1L;
    private Exception ex;

    /**
     * 默认异常处理，转移Exception总类进行处理
     *
     * @pdOid 31aca3e2-0b05-4bdb-96d0-8362a39c6df8
     */
    public SkyLotException() {
        super();
    }

    /**
     * @param message the detail message. The detail message is saved for later
     *                <p>
     *                retrieval by the {@link #getMessage()} method.
     * @pdOid 5dd6ca07-e0be-4489-8e83-94aff12a4ecc
     */
    public SkyLotException(String message) {
        super(message);
    }

    public SkyLotException(String message, String errorLevel) {

        super(message);
    }

    /**
     * @param message the detail message (which is saved for later retrieval by the
     *                <p>
     *                {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                <p>
     *                {@link #getCause()} method). (A <tt>null</tt> value is
     *                <p>
     *                permitted, and indicates that the cause is nonexistent or
     *                <p>
     *                unknown.)
     * @pdOid 62374066-9273-4bc9-8892-384a61637829
     * @since 1.4
     */
    public SkyLotException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause the cause (which is saved for later retrieval by the
     *              <p>
     *              {@link #getCause()} method). (A <tt>null</tt> value is
     *              <p>
     *              permitted, and indicates that the cause is nonexistent or
     *              <p>
     *              unknown.)
     * @pdOid e1aae73a-a270-49ee-adf1-7adfb04cd871
     * @since 1.4
     */
    public SkyLotException(Throwable cause) {
//        super(cause);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassName:");
        stringBuilder.append(cause.getStackTrace()[0].getClassName());
        stringBuilder.append("  ");
        stringBuilder.append(" MethodName: ");
        stringBuilder.append(cause.getStackTrace()[0].getMethodName());
        stringBuilder.append("  ");
        stringBuilder.append(" LineNumber: ");
        stringBuilder.append(cause.getStackTrace()[0].getLineNumber());
        stringBuilder.append("  ");
        stringBuilder.append(" DetailMessage: ");
        stringBuilder.append(cause.getMessage());
        log.error(stringBuilder.toString());
    }

}