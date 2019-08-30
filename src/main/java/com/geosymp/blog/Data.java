package com.geosymp.blog;

import com.geosymp.blog.models.Member;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Member> members(){
        return new ArrayList<Member>(   ){{
            add(new Member("John Developer","Senior Engineer", 36.783022,-1.289037));
            add(new Member("Uncle Sam","QA Specialist", 36.789177,-1.284348));
            add(new Member("Steve Bob","DBA", 36.784718, -1.282927));
            add(new Member("Donalt Truth","Project Manager", 36.819022, -1.278265));
            add(new Member("Jane West","Health Information System Specialist", 36.817024, -1.299982));
        }};

    }
}
