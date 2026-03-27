package com.example.currency_converter_service;

import com.example.currency_converter_service.entity.CurrencyDetail;
import com.example.currency_converter_service.repository.CurrencyConvertorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
// XML parsing imports

import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {

    @Value("classpath:fx-rates.xml")   // ← points to your XML
    private Resource xmlResource;

    private final CurrencyConvertorRepository currencyConvertorRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(xmlResource.getInputStream());

        doc.getDocumentElement().normalize();

        // ✅ Get root
        Element root = doc.getDocumentElement();

        // ✅ Get all child nodes properly
        NodeList nodes = root.getElementsByTagName("Conversion"); // <-- FIX HERE

        log.info("length: {}", nodes.getLength());

        for (int i = 0; i < nodes.getLength(); i++) {

            Element el = (Element) nodes.item(i);

            String from = el.getElementsByTagName("From").item(0).getTextContent();
            String to = el.getElementsByTagName("To").item(0).getTextContent();
            Double rate = Double.parseDouble(
                    el.getElementsByTagName("Rate").item(0).getTextContent()
            );
            LocalDate asOf = LocalDate.parse(
                    el.getElementsByTagName("AsOf").item(0).getTextContent()
            );

            log.info("from: {} to: {} rate: {} asOf: {}", from, to, rate, asOf);

            currencyConvertorRepository.save(
                    new CurrencyDetail(null, from, to, null, null, rate, asOf)
            );
        }

        System.out.println("✅ XML data loaded into DB!");
    }

}
