package ua.com.tarastomkevich.util;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public  class FilterFileSubtitle extends FileFilter {

    @Override
    public boolean accept(File pathname) {
        String filename = pathname.getName();
        if (pathname.isDirectory()) {
            return true;

        } else if (filename.endsWith("srt")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Subtitle files";
    }
}