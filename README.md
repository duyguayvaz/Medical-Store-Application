# Medical Store Management System

Bu proje, bir eczane (medical store) yönetim sistemi geliştirmek amacıyla hazırlanmıştır. Kullanıcılar ilaç bilgilerini sistemde tutabilir, düzenleyebilir, arayabilir ve silebilir. Proje, hem komut satırı (CLI) hem de grafiksel kullanıcı arayüzü (GUI) olarak iki versiyon içerir.

---

## 🗂️ Proje Yapısı

Medical-Store-Application/
├── ce103_hw4_medical_store_app/       → GUI tabanlı Java uygulaması  
│   └── src/ce103_hw4_medical_store_app/
│       ├── Menu.java
│       ├── InsiderOfTheMenu.java
│       └── (diğer GUI sınıfları)
├── ce103_hw4_medical_store_cmd/       → CLI tabanlı Java uygulaması  
│   └── src/ce103_hw4_medical_store_cmd/
│       ├── Medical_Store.java
│       └── (diğer komut satırı bileşenleri)
├── doxyfile_dev                        → Doxygen yapılandırma dosyası  
├── doxygen_log.txt                    → Belgeler oluşturulurken oluşan loglar  
└── README.md                          → Proje hakkında bilgiler

---

## 🚀 Çalıştırma Talimatları

### Gereksinimler:

- Java JDK 8 veya üzeri
- Bir Java IDE (örneğin Eclipse, IntelliJ IDEA) ya da terminal

### Eclipse ile çalıştırmak için:

1. Eclipse’i açın.
2. `File > Import > Existing Projects into Workspace` yolunu izleyin.
3. `ce103_hw4_medical_store_app` veya `ce103_hw4_medical_store_cmd` klasörünü seçin.
4. İlgili `Menu.java` ya da `Medical_Store.java` sınıfını çalıştırın.

### Terminal ile çalıştırmak için:

1. Terminali açın ve proje dizinine gidin.
2. Komut satırı versiyonu için şu komutları yazın:

```
cd ce103_hw4_medical_store_cmd/src
javac ce103_hw4_medical_store_cmd/Medical_Store.java
java ce103_hw4_medical_store_cmd.Medical_Store
```

GUI versiyonu için:

```
cd ce103_hw4_medical_store_app/src
javac ce103_hw4_medical_store_app/Menu.java
java ce103_hw4_medical_store_app.Menu
```

---

## 🔧 Özellikler

- İlaç ekleme, silme ve düzenleme
- Stok takibi
- Arama fonksiyonu (isim ile)
- Komut satırı ve GUI arayüz seçenekleri
- Kolay kullanımlı yapı
- Java ile tamamen nesne yönelimli programlama prensiplerine uygun geliştirilmiştir

---

## 📄 Belgeler

Proje içinde yer alan `doxyfile_dev` dosyası ile Doxygen belgeleri oluşturabilirsiniz.

Oluşturmak için:

1. `doxygen doxyfile_dev` komutunu çalıştırın (doxygen sisteminizde kurulu olmalı).
2. `docs/` klasörüne HTML dökümanları oluşturulacaktır.

---

## 📜 Lisans

Bu proje eğitim amaçlı geliştirilmiştir. Herhangi bir ticari kullanım amacı taşımaz.
