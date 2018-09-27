package com.example.jessi.rjt_project_01.data.localdata;

import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class ModelValidation {

    private static final String TAG = "Model_ValSTARTED";
//--------------------------------------------------------------------------------------------------

    public ModelValidation() {
    }

//--------------------------------------------------------------------------------------------------

    boolean match = false;
    private Pattern pattern;

    boolean isVal = true;

    ArrayList<String> FieldNamesStrings;
    ArrayList<String> PatternStrings;
    ArrayList<String> TextViewStrings;
    ArrayList<Boolean> FieldResults;

    String errormsg;

    int index = 0;

//--------------------------------------------------------------------------------------------------
    public ModelValidation(final ArrayList<String> patterns, ArrayList<String> fieldnames)
    {
        Log.d(TAG, "ModelValidation: STARTED");

        PatternStrings = patterns;
        TextViewStrings = new ArrayList<>();
        FieldNamesStrings = new ArrayList<>();
        FieldResults = new ArrayList<>();
        for (int i = 0; i < PatternStrings.size(); i++)
        {
            FieldNamesStrings.add(fieldnames.get(i));
        }
    }


//--------------------------------------------------------------------------------------------------

//    private static final String USERNAME_PATTERN = "^[ A-Za-z0-9._-]{3,15}$";
//    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9.-_!]{6,18}$";
//    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]{3,20}@[a-zA-Z0-9]{3,9}.com$";
//    private static final String DOB_PATTERN = "^(\\d{2}-?\\d{2}-?\\d{4})$";
//--------------------------------------------------------------------------------------------------

    public void addPatternString(final String input)
    {
        PatternStrings.add(input);
    }
//--------------------------------------------------------------------------------------------------

    public void addTextViewString(String input)
    {
        TextViewStrings.add(input);
    }
//--------------------------------------------------------------------------------------------------


    public boolean validation()
    {
        Log.d(TAG, "validation: STARTED");

        this.isVal = true;
        for (int i = 0; i < PatternStrings.size(); i++)
        {
            pattern = Pattern.compile(PatternStrings.get(i));
            match = pattern.matcher(TextViewStrings.get(i)).matches();
            if (!match) {
                Boolean tempbool = new Boolean(false);
                FieldResults.add(tempbool);
                isVal = false;
            }
            else {
                Boolean tempbool = new Boolean(true);
                FieldResults.add(tempbool);
            }
        }
        setFailResuls();

        //Clear for another attempt
        TextViewStrings.clear();
        FieldResults.clear();


         return isVal;
    }
//--------------------------------------------------------------------------------------------------
    private void setFailResuls()
    {
        Log.d(TAG, "setFailResuls: STARTED");
         errormsg = "Field Results: \n";

        for (int i = 0; i< FieldNamesStrings.size(); i++)
        {
            if (FieldResults.get(i).booleanValue())
            {
                errormsg += "\n SUCCESS: " + FieldNamesStrings.get(i);
                continue;
            }
            else
            {

                errormsg += "\n FAILED: " + FieldNamesStrings.get(i) + ": "+ TextViewStrings.get(i) + "--->Pattern : "  +PatternStrings.get(i) ;
                //this.isVal = false;
            }

            errormsg += "\n PatternStrings: " + PatternStrings.size();
            errormsg += "\n FieldNamesStrings: " + FieldNamesStrings.size();
            errormsg += "\n TextViewStrings: " + TextViewStrings.size();
            errormsg += "\n FieldResults: " + FieldResults.size();
        }
    }

    public String getErrormsg()
    {
        Log.d(TAG, "getErrormsg: STARTED");
        return this.errormsg;
    }
    private boolean isMatch() {
        return match;
    }

}
