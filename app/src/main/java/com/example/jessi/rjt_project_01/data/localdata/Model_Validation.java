package com.example.jessi.rjt_project_01.data.localdata;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Model_Validation {
    public Model_Validation() {

    }
    private static final String TAG = "|===========InputValidation: ";
    boolean match = false;
    private Pattern pattern;

    ArrayList<String> FieldNamesStrings;
    ArrayList<String> PatternStrings;
    ArrayList<String> TextViewStrings;
    ArrayList<Boolean> FieldResults;

    int index = 0;

    public Model_Validation(final ArrayList<String> patterns, ArrayList<String> fieldnames)
    {
        PatternStrings = patterns;
        TextViewStrings = new ArrayList<>();
        FieldNamesStrings = new ArrayList<>();
        for (int i = 0; i < PatternStrings.size(); i++)
        {
            TextViewStrings.add("");
            FieldNamesStrings.add(fieldnames.get(i));
        }
    }

//    private static final String USERNAME_PATTERN = "^[ A-Za-z0-9._-]{3,15}$";
//    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9.-_!]{6,18}$";
//    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]{3,20}@[a-zA-Z0-9]{3,9}.com$";
//    private static final String DOB_PATTERN = "^(\\d{2}-?\\d{2}-?\\d{4})$";



    public void addPatternString(final String input)
    {
        PatternStrings.add(input);
    }

    public void addTextViewString(String input)
    {
        TextViewStrings.add(input);
    }

    public boolean validation(String Error)
    {
        boolean isVal = true;

        for (int i = 0; i < PatternStrings.size(); i++)
        {
            pattern = Pattern.compile(PatternStrings.get(i));
            match = pattern.matcher(TextViewStrings.get(i)).matches();
            if (!match) {
                FieldResults.add(false);
                isVal = false;
            }
            else {
                FieldResults.add(true);
            }
        }

        if (!isVal)
        {
            Error = getFailResuls();
        }
        return isVal;
    }

    public String getFailResuls()
    {
        String ErrorMsg = "Feild Results: \n";

        for (int i = 0; i< FieldNamesStrings.size(); i++)
        {
            if (FieldResults.get(i))
            {
                ErrorMsg += "SUCCESS!";
                continue;
            }
            else
            {
                ErrorMsg += "\t Invalid: " + FieldNamesStrings.get(i);
            }
        }
        return ErrorMsg;
    }
    public boolean isMatch() {
        return match;
    }
}
