package org.jboss.hal.samples.rich.client.model;

import com.google.web.bindery.autobean.shared.AutoBean;
import org.jboss.as.console.spi.BeanFactoryExtension;

/**
 * @author Harald Pehl
 */
@BeanFactoryExtension
public interface RichSampleBeanFactory
{
    AutoBean<RichSampleModel> getModel();
}
