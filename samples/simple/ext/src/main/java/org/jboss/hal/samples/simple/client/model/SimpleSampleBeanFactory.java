package org.jboss.hal.samples.simple.client.model;

import com.google.web.bindery.autobean.shared.AutoBean;
import org.jboss.as.console.spi.BeanFactoryExtension;

/**
 * @author Harald Pehl
 */
@BeanFactoryExtension
public interface SimpleSampleBeanFactory
{
    AutoBean<SimpleSampleModel> getSimpleSampleModel();
}
