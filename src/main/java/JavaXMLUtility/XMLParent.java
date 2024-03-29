package JavaXMLUtility;

import java.util.*;

public class XMLParent implements XMLHeader{
    private final String name;
    private String content = null;
    private final List<XMLHeader> children = new ArrayList<>();
    private final Set<String> childrenTitles = new HashSet<>();
    private final Map<String, XMLAttribute> attributes = new HashMap<>();

    public XMLParent(final String name){
        this.name = name;
    }

    @Override
    public final String getName(){
        return name;
    }

    @Override
    public final String getContent(){
        return content;
    }

    @Override
    public List<XMLHeader> getChildren() {
        return children;
    }

    @Override
    public final XMLAttribute getAttribute(final String attribute){
        return attributes.get(attribute);
    }

    @Override
    public final boolean containsAttribute(final String attribute){
        return attributes.containsKey(attribute);
    }

    @Override
    public final List<XMLAttribute> getAttributes(){
        final List<XMLAttribute> attrs = new ArrayList<>();
        for(final String key : attributes.keySet()){
            attrs.add(attributes.get(key));
        }

        return attrs;
    }

    @Override
    public final boolean containsChild(final String child){
        return childrenTitles.contains(child);
    }

    protected final void addChild(final XMLParent child){
        children.add(child);
        childrenTitles.add(child.name);
    }

    protected final void addAttribute(final String attributeName, final String attribute){
        addAttribute(new XMLAttribute(attributeName, attribute));
    }

    protected final void addAttribute(final XMLAttribute attribute){
        attributes.put(attribute.getName(), attribute);
    }

    protected final void setContent(final String content){
        this.content = content;
    }

    @Override
    public final boolean equals(final Object o){
        if(o instanceof String) return name.equals(o);
        return super.equals(o);
    }
}
