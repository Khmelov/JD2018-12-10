package by.it.titkovskaya.jd02.jd02_09.converter;

class ConverterFactory<Bean> {

    Converter getConverter(Direction direction, Class<Bean> beanClass) {
        switch (direction) {
            case JSON_TO_XML:
                return new ConverterJsonToXml(beanClass);
            case XML_TO_JSON:
                return new ConverterXmlToJson(beanClass);
            default:
                return null;
        }
    }

}
