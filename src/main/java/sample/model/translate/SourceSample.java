package sample.model.translate;

@TargetAnnotation(TargetSample.class)
public class SourceSample {
    @NameAnnotation("foo")
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
