package editor;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import editor.service.EditorServiceImpl;

/**
 * path application
 */
@ApplicationPath("/editor")
public class EditorApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(EditorServiceImpl.class);

        return resources;
    }
}
