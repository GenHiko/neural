package cn.ms.neural.common.exception;

/**
 * 放通率拒绝异常
 * 
 * @author lry
 */
public class PipeScalingException extends RuntimeException {

	private static final long serialVersionUID = 7815426752583648734L;

    public static final int UNKNOWN_EXCEPTION = 0;
    public static final int NETWORK_EXCEPTION = 1;
    public static final int TIMEOUT_EXCEPTION = 2;
    public static final int BIZ_EXCEPTION = 3;
    public static final int FORBIDDEN_EXCEPTION = 4;
    public static final int SERIALIZATION_EXCEPTION = 5;
    private int code;

    public PipeScalingException() {
        super();
    }

    public PipeScalingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PipeScalingException(String message) {
        super(message);
    }

    public PipeScalingException(Throwable cause) {
        super(cause);
    }

    public PipeScalingException(int code) {
        super();
        this.code = code;
    }

    public PipeScalingException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public PipeScalingException(int code, String message) {
        super(message);
        this.code = code;
    }

    public PipeScalingException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
    
    public boolean isBiz() {
        return code == BIZ_EXCEPTION;
    }
    
    public boolean isForbidded() {
        return code == FORBIDDEN_EXCEPTION;
    }

    public boolean isTimeout() {
        return code == TIMEOUT_EXCEPTION;
    }

    public boolean isNetwork() {
        return code == NETWORK_EXCEPTION;
    }

    public boolean isSerialization() {
        return code == SERIALIZATION_EXCEPTION;
    }

}
