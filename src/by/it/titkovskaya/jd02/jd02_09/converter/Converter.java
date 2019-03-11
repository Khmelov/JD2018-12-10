package by.it.titkovskaya.jd02.jd02_09.converter;

import java.io.*;

public abstract class Converter<Bean> {

    private Bean bean;
    private Class<Bean> beanClass;

    Converter(Class<Bean> beanClass) {
        this.beanClass = beanClass;
    }

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public Class<Bean> getBeanClass() {
        return beanClass;
    }

    void load(File source) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()){
                builder.append(reader.readLine()).append("\n");
            }
            load(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    abstract String getText();

    abstract void load(String text);

    void save(String output, File fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
