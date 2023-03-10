/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.wildfirechat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heavyrain on 2017/12/13.
 */

public class GroupSearchResult implements Parcelable {
    public interface GroupSearchMarchTypeMask {
        //march group name
        int Group_Name_Mask = 0x01;
        //march member user name
        int Member_Name_Mask = 0x02;
        //march group member alias
        int Member_Alias_Mask = 0x04;
        //march group remark
        int Group_Remark_Mask = 0x08;
    }

    public GroupInfo groupInfo;
    //GroupSearchMarchTypeMask
    public int marchedType;
    public List<String> marchedMembers;

    public GroupSearchResult() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.groupInfo, flags);
        dest.writeInt(this.marchedType);
        dest.writeList(marchedMembers != null ? marchedMembers : new ArrayList<String>());
    }

    protected GroupSearchResult(Parcel in) {
        this.groupInfo = in.readParcelable(GroupInfo.class.getClassLoader());
        this.marchedType = in.readInt();
        this.marchedMembers = in.readArrayList(ClassLoader.getSystemClassLoader());
    }

    public static final Creator<GroupSearchResult> CREATOR = new Creator<GroupSearchResult>() {
        @Override
        public GroupSearchResult createFromParcel(Parcel source) {
            return new GroupSearchResult(source);
        }

        @Override
        public GroupSearchResult[] newArray(int size) {
            return new GroupSearchResult[size];
        }
    };
}
