package com.jstarcraft.rns.search;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.jstarcraft.rns.search.annotation.SearchEncode;

/**
 * 模仿简单输入
 * 
 * @author Birdy
 *
 */
public class MockSimpleInput {

    @SearchEncode(index = true, sort = true, store = true)
    private long id;

    @SearchEncode(index = true, sort = true, store = true)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        MockSimpleInput that = (MockSimpleInput) object;
        EqualsBuilder equal = new EqualsBuilder();
        equal.append(this.id, that.id);
        equal.append(this.name, that.name);
        return equal.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hash = new HashCodeBuilder();
        hash.append(id);
        hash.append(name);
        return hash.toHashCode();
    }

    public static MockSimpleInput instanceOf(long id, String name) {
        MockSimpleInput instance = new MockSimpleInput();
        instance.id = id;
        instance.name = name;
        return instance;
    }

}
