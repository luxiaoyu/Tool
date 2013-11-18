package com.baidu.chunlei.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SSHHelper {
    private static String mStdOut = null;

    public static int executeLocalCommand(String command) {
        String[] commandString = { "/bin/bash", "-c", command };
        return executeCommand(commandString);
    }

    public static int executeRemoteCommand(String host, String password, String command) {
        String[] commandString = {
                "/bin/bash",
                "-c",
                "cd " + System.getProperty("user.dir") + File.separator + "tools" + ";./execute " + host + " "
                        + password + " " + command };
        return executeCommand(commandString);
    }

    public static int scp(String password, String source, String destination) {
        String[] commandString = {
                "/bin/bash",
                "-c",
                "cd " + System.getProperty("user.dir") + File.separator + "tools" + ";./pscp " + password + " "
                        + source + " " + destination };
        return executeCommand(commandString);
    }

    private static int executeCommand(String[] commandString) {
        int ret = -1;
        try {
            Process process = Runtime.getRuntime().exec(commandString);
            InputStream stdout = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                mStdOut += line + "\n";
            }

            ret = process.waitFor();
            if (ret != 0) {
                System.err.println(mStdOut);
                System.err.println("Command \"" + commandString + "\" is failed!\n" + "ret is " + ret);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    public String[] getStdOutLines(){
        return mStdOut.split("\n");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String host = "luxiaoyu@172.21.6.11";
        String password = "123456";
        String command = "last";
        SSHHelper ssh = new SSHHelper();
        //ssh.executeLocalCommand("pwd");
        //ssh.executeRemoteCommand(host, password, command);
        ssh.scp("123456", "/home/luxiaoyu/workspace/Octopus", "luxiaoyu@172.21.6.11:/home/luxiaoyu/temp");
    }

}
