package com.ericsson.ci.cloud.eniq_cdb_setup.test.data;

public class PackageInfo {

	public PackageInfo(String packageName, String version) {
		super();
		this.packageName = packageName;
		this.version = version;
	}

	private String packageName;
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public String toString() {
		return " " + packageName + " " + version;
	}

}
