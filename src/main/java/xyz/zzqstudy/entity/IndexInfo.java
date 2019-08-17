package xyz.zzqstudy.entity;

import org.springframework.stereotype.Component;

//@Component
public class IndexInfo {
    private String code;
    private String name;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IndexInfo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", isSelect=" + isSelect +
                '}';
    }
}
