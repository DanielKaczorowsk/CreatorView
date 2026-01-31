package com.example.bringmanage.CreatorTask.BMExceptions;

public class BMException extends RuntimeException implements IBMExceptions
{
    public int code;
    /**
     * enum to use exceptions which have error code and message*/
    public enum ErrorCode {
        EMPTY_DTO(404,"Empty record in DTO"),
        EMPTY_LAYOUT(400,"Don't found layout"),
        EMPTY_CLASS(400,"Don't found class"),
        ARG_ARRAY(400,"Too much arguments in table");

        private final int codeNumber;
        private final String message;

        private ErrorCode(int codeNumber , String message)
        {
            this.codeNumber = codeNumber;
            this.message = message;
        }
        public int getCode() {
            return codeNumber;
        }
        public String getMessage(){
            return message;
        }
    }
    /**
     * Exceptions logic to throw error default code*/
    public BMException(ErrorCode errorCode)
    {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }
    /**
     * Exceptions logic to throw error with code */
    public BMException(ErrorCode errorCode , int customCode)
    {
        super(errorCode.getMessage());
        this.code = customCode;
    }
}
