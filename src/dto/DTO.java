package dto;

public class DTO {
	
	 //״̬�룬1����ɹ���-1�����쳣
    public String code = "1";
    //�ɹ������쳣��Ϣ
    public String msg = "success";
    //������
    public Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
