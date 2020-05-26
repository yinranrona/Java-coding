/*
 * WebApp_t-ex01
 * model.entity.UserBean.java
 */
package model.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * ユーザを表します。
 * m_userのDTOであり、Beanオブジェクトです。
 * @author emBex Education
 */
public class UserBean implements Serializable {

	/**
	 * ユーザID
	 */
	private String userId;

	/**
	 * 氏名
	 */
	private String name;

	/**
	 * タイムスタンプ
	 */
	//SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//private int update_datetime;
	Date timeStamp = new Date();
    /**
	 * UserBeanを構築します。
	 */
	public UserBean() {

	}

	/**
	 * フィールドuserIdの値を返します。
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * フィールドuserIdの値を設定します。
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * フィールドnameの値を返します。
	 * @return 氏名
	 */
    public String getName() {
        return name;
    }

    /**
     * フィールドnameの値を設定します。
     * @param name 氏名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * フィールドtimeStampの値を返します。
     * @return タイムスタンプ
     */
	public Date getTimestamp() {
        return timeStamp;
    }

	/**
	 * フィールドtimeStampの値を設定します。
	 * @param timeStamp タイムスタンプ
	 */
    public void setTimestamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
