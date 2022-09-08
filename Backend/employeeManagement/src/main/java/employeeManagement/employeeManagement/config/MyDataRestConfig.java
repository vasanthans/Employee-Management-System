package employeeManagement.employeeManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;
    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager=theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // Call an internal expose method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // Expose entity Ids

        // Get a list of all entity classes from entity manager
        Set<EntityType<?>> entities= entityManager.getMetamodel().getEntities();

        // Create an array of the entity types
        List<Class> entityClass=new ArrayList<>();

        // Get the entity types of an entities
        for(EntityType tempEntityType: entities) {
            entityClass.add(tempEntityType.getJavaType());
        }

        // Expose the entity Ids for an array of entity/domain types
        Class[] domainType=entityClass.toArray(new Class[0]);
        config.exposeIdsFor(domainType);
    }
}
