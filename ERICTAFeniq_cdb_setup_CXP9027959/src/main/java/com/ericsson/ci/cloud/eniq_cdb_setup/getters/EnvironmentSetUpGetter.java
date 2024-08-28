package com.ericsson.ci.cloud.eniq_cdb_setup.getters;

import com.ericsson.cifwk.taf.data.DataHandler;
import com.ericsson.cifwk.taf.data.Host;
import com.ericsson.cifwk.taf.tools.cli.CLI;
import com.ericsson.cifwk.taf.tools.cli.Shell;

public class EnvironmentSetUpGetter {

    private static String configFiles;
    private static String hostName;
    private static String scriptPath;
    private static String cloudInfo;
    private static String mediaFile;
    private static String inirFile;
    private static final Host host = DataHandler.getHostByName("gateway");
    
    private static String getConfigFiles() {
        if (configFiles == null)
            configFiles = DataHandler.getAttribute("CONFIG_FILES").toString();
        return configFiles;

    }

    private static String getHostName() {
        if (hostName == null){
        	CLI cli = new CLI(host);
        	Shell sh = cli.executeCommand("hostname");
        	hostName = sh.read();
        	sh.disconnect();
        	//            hostName = DataHandler.getHostByName("gateway").getIp();
        
        }return hostName;
    }
    
    private static String getScriptPath() {
    	if (scriptPath == null) {
        	scriptPath = DataHandler.getAttribute("scriptPath").toString();
    	}
        return scriptPath;

    }

    private static String getInirFile() {
		if (inirFile == null) {
			inirFile = DataHandler.getAttribute("inirFile").toString();
		}
		return inirFile;
	}

	private static String getMediaFile() {
		if (mediaFile == null) {
			mediaFile = DataHandler.getAttribute("mediaFile").toString();
		}
		return mediaFile;
	}

	private static String getCloudInfo() {
		if (cloudInfo == null) {
			cloudInfo = DataHandler.getAttribute("cloudInfo").toString();
		}
		return cloudInfo;
	}

	/*public static String getInitialInstallCommand() {
		return "" + getScriptPath() + "/bin/master.sh -c " + getScriptPath()
				+ getInirFile() + " " + getScriptPath() + getMediaFile() + " "
				+ getScriptPath() + getCloudInfo() + " -f full_rollout";
	}*/
    public static String getInitialInstallCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + " -g `hostname` -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_ENIQ_STATS -f full_rollout";
    }
    
    //Command for ddp
    /*public static String getDdcDdpiSetupCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + " -g `hostname` -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f rollout_config";
    }
    
	//Command for Cloud upgrade
    public static String getInitialUpgradeCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + " -g `hostname` -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f upgrade_adm";
    }

    //Command for initialising MC's
    public static String getManageMCCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + " -g `hostname` -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f manage_mcs_initial";
    }
    

    public static String getArneImportCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f netsim_post_steps";
    }

    public static String getAddUserCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + " -g `hostname` -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f create_users_config";

    }
    
    public static String getSimdepCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f simdep_call";
    }
    
    //Command to disable password expiry
    public static String getDisablePasswordExpiryCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f disable_password_expiry";
    }
    
    public static String getDisablePasswordLockoutCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f disable_password_lockout";
    }
    
    public static String getDisablePasswordMustChangeCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f disable_password_must_change";
    }
    
    public static String getRemovePasswordChangeHistoryCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f remove_password_change_history";
    }
    
    public static String getReduceMinPasswordLengthCommand() {
        return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f reduce_min_password_length";
    }

	public static String getNetsimRollOutConfigCommand() {
	    return "" + getScriptPath() + "/bin/master.sh -c " + getConfigFiles() + "  -g `hostname`  -o yes -l " + getScriptPath() + "/logs/web/CI_EXEC_OSSRC/ -f  netsim_rollout_config";	      
	}
    */
    
}
