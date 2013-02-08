package org.jboss.hal.samples.simple.client.gin;

import com.google.gwt.inject.client.AsyncProvider;
import org.jboss.as.console.spi.GinExtension;
import org.jboss.hal.samples.simple.client.SimpleSamplePresenter;

/**
 * @author Harald Pehl
 */

@GinExtension("org.jboss.hal.samples.simple.SimpleSample")
public interface Extension
{
    AsyncProvider<SimpleSamplePresenter> getSimpleSamplePresenter();
}
