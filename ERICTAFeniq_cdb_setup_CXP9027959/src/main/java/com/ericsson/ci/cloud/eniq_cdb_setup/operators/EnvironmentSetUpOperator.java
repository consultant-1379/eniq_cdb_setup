package com.ericsson.ci.cloud.eniq_cdb_setup.operators;

public interface EnvironmentSetUpOperator {

    boolean executeInitialInstall();
    
    /*boolean executeDdcDdpiSetup();

    boolean executeInitialUpgrade();

    boolean manageMC();

    boolean executeArneImport();

    boolean prepareUsers();

    boolean executeSimdep();

    boolean disablePasswordExpiry();

    boolean disablePasswordLockout();

    boolean disablePasswordMustChange();

    boolean removePasswordChangeHistory();

    boolean reduceMinPasswordLength();

    boolean executeNetsimRollOutConfig();
*/
}
