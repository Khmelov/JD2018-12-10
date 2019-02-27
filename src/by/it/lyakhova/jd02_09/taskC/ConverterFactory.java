package by.it.lyakhova.jd02_09.taskC;


class ConverterFactory{


    Converter getConverter(Direction direction, Class beanClass){
        switch (direction) {
            case JSON_TO_XML:
                return new ConverterJsonToXml(beanClass);
            case XML_TO_JSON:
                return new ConverterXmlToJson(beanClass);
            default: return null;
        }
    }
}
