package ru.alpo.hw_library.initializer.datainitializer;

import ru.alpo.hw_library.initializer.serviceinitializer.*;

public final class DataInitializerFactory {
    private DataInitializerFactory() {
    }

    public static BasicDataInitalizer getDataInitializer(DataInitializerType dataInitializerType, ServiceHolder serviceHolder) {

        switch (dataInitializerType) {
            case IN_MEMORY:
                return new InMemoryInitializer(serviceHolder);
            case FROM_TXT_FILE:
                return new FromTxtInitializer(serviceHolder);
            default:
                throw new IllegalStateException("Unexpected value: " + dataInitializerType);
        }
    }

}
