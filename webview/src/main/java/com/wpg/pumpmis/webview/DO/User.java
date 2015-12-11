package com.wpg.pumpmis.webview.DO;

public class User {
	/**
	 *      <Xh>string</Xh>
        <LoginId>string</LoginId>
        <LoginPwd>string</LoginPwd>
        <Name>string</Name>
        <ProvinceXh>string</ProvinceXh>
        <LastUpdatetime>dateTime</LastUpdatetime>
        <AddTime>dateTime</AddTime>
        <AreaXh>string</AreaXh>
        <LogincheckNo>string</LogincheckNo>
        <CompanyXh>string</CompanyXh>
        <EmployeeNo>string</EmployeeNo>
        <DeptXh>string</DeptXh>
        <Reserve>decimal</Reserve>
        <Roleid>string</Roleid>
        <Logontimes>decimal</Logontimes>
        <Lastlogonip>string</Lastlogonip>
        <Logonip>string</Logonip>
        <Lastlogontime>dateTime</Lastlogontime>
        <Logontime>dateTime</Logontime>
        <Nullity>decimal</Nullity>
        <Currheadimgurl>string</Currheadimgurl>
        <Signmsg>string</Signmsg>
        <Email>string</Email>
      </GetUserResult>
	 */
	public User(){}
	
	private String Name;
	private String LoginPwd;
	private String LoginId;
	private String Xh;
	
	public String getXh() {
		return Xh;
	}

	public void setXh(String xh) {
		Xh = xh;
	}

	private String AddTime;
	
	public String getAddTime() {
		return AddTime;
	}

	public void setAddTime(String addTime) {
		AddTime = addTime;
	}

	private String Logontimes;
	
	public String getLogontimes() {
		return Logontimes;
	}

	public void setLogontimes(String logontimes) {
		Logontimes = logontimes;
	}

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		LoginId = loginId;
	}


	public String getProvinceXh() {
		return ProvinceXh;
	}

	public void setProvinceXh(String provinceXh) {
		ProvinceXh = provinceXh;
	}

	private String ProvinceXh;

	public String getLoginPwd() {
		return LoginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		LoginPwd = loginPwd;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}


}
