package jungjaehun.libraryexample;

import android.content.Intent;

/**
 * Created by jaehoonjung on 2017. 5. 13..
 */

public class ExampleData {
    private String exampleTitle;
    private Intent exampleIntent;

    public ExampleData(String exampleTitle, Intent exampleIntent) {
        this.exampleTitle = exampleTitle;
        this.exampleIntent = exampleIntent;
    }

    public String getExampleTitle() {
        return exampleTitle;
    }

    public Intent getExampleIntent() {
        return exampleIntent;
    }

}
