package com.deepak.jsonparsing.children;

import com.google.gson.annotations.SerializedName;

public class Children {
    @SerializedName("kind")
    private  String kind;
    @SerializedName("data")
    private Data data;

    @Override
    public String toString() {
        return "Children{" +
                "kind='" + kind + '\'' +
                ", data=" + data +
                '}';
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
