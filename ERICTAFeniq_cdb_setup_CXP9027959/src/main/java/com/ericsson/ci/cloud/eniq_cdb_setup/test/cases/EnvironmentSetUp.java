package com.ericsson.ci.cloud.eniq_cdb_setup.test.cases;

import javax.inject.Inject;

import org.testng.annotations.Test;

import com.ericsson.cifwk.taf.TestCase;
import com.ericsson.cifwk.taf.TorTestCaseHelper;
import com.ericsson.cifwk.taf.annotations.Context;
import com.ericsson.cifwk.taf.annotations.TestId;
import com.ericsson.cifwk.taf.guice.OperatorRegistry;
import com.ericsson.ci.cloud.eniq_cdb_setup.operators.EnvironmentSetUpOperator;

public class EnvironmentSetUp extends TorTestCaseHelper implements TestCase {

    @Inject
    OperatorRegistry<EnvironmentSetUpOperator> operatorRegistry;

    /*@Inject
    OperatorRegistry<ARNESetUpOperator> ARNEOperatorRegistry;
*/
    private EnvironmentSetUpOperator getOperator() {
        return operatorRegistry.provide(EnvironmentSetUpOperator.class);
    }

    /*private ARNESetUpOperator getARNEOperator() {
        return ARNEOperatorRegistry.provide(ARNESetUpOperator.class);
    }*/

    @TestId(id = "CIP-8129_Func_1")
    @Context(context = { Context.CLI })
    @Test(priority = 1)
    public void verifyEnvironmentInstallation() {
        assertTrue(getOperator().executeInitialInstall());
    }

    /*@TestId(id = "CIP-9163_Func_1")
    @Context(context = { Context.CLI })
    @Test(priority = 2)
    public void verifyDdcDdpiSetup() {
        assertTrue(getOperator().executeDdcDdpiSetup());
    }
    
    @TestId(id = "CIP-8129_Func_2")
    @Context(context = { Context.CLI })
    @Test(priority = 3)
    public void verifyNetworkPreparation() {

        setTestStep("Offline MAF");
        assertTrue(getARNEOperator().mafOffline());
        setTestStep("Offline IMS");
        assertTrue(getARNEOperator().imsOffline());
        setTestStep("ARNE IMPORT");
        assertTrue(getOperator().executeArneImport());
        setTestStep("Online MAF");
        assertTrue(getARNEOperator().mafOnline());

        setTestStep("Sleep for 2.5 min and start MAF synch");
        assertTrue(getARNEOperator().mafSynch());
        setTestStep("Online IMS");
        assertTrue(getARNEOperator().imsOnline());

    }

    @TestId(id = "CIP-8129_Func_3")
    @Context(context = { Context.CLI })
    @Test(priority = 4)
    public void verifyUsersPreparation() {
        assertTrue(getOperator().prepareUsers());
    }

    @TestId(id = "CIP-8129_Func_4")
    @Context(context = { Context.CLI })
    @Test(priority = 5)
    public void verifyDisableOfPasswordPolicy() {

        setTestStep("disablePasswordExpiry");
        assertTrue(getOperator().disablePasswordExpiry());

        setTestStep("disablePasswordLockout");
        assertTrue(getOperator().disablePasswordLockout());

        setTestStep("disablePasswordMustChange");
        assertTrue(getOperator().disablePasswordMustChange());

        // setTestStep("reduceMinPasswordLength");
        // assertTrue(getOperator().reduceMinPasswordLength());

        setTestStep("disablePasswordChangeHistory");
        assertTrue(getOperator().removePasswordChangeHistory());

    }

    @TestId(id = "CIP-8129_Func_5")
    @Context(context = { Context.CLI })
    @Test(priority = 6)
    public void showNodeSynchStatus() {

        setTestStep("Show Node Synch Status");
        getARNEOperator().getNodeSynchStatus();
        assertTrue(true);

    }*/
}
