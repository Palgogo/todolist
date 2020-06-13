package by.palgogo.todolist.util;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestUtil {

    public static <T> void equalsVerifier(Class<T> clazz) throws Exception {
        T domainObject1 = clazz.getConstructor().newInstance();
        assertThat(domainObject1.toString()).isNotNull();
        assertThat(domainObject1).isEqualTo(domainObject1);
        assertThat(domainObject1.hashCode()).isEqualTo(domainObject1.hashCode());
        //Test with an instance of another class
        Object testAnotherObject = new Object();
        assertThat(domainObject1).isNotEqualTo(testAnotherObject);
        assertThat(domainObject1).isNotEqualTo(null);
        //Test with an instance of another class
        T domainObject2 = clazz.getConstructor().newInstance();
        assertThat(domainObject1).isNotEqualTo(domainObject2);
        //Hashcodes are equal because the objects are not persisted yet
        assertThat(domainObject1.hashCode()).isEqualTo(domainObject2.hashCode());
    }
}
