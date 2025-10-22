# Проект автоматизации тестирования для мобильного приложения [uHabits](https://github.com/iSoron/uhabits)

<p align="center">
  <img src="images/screensApk/1.png" width="150" />
  <img src="images/screensApk/2.png" width="150" />
  <img src="images/screensApk/3.png" width="150" />
</p>
<p align="center">
  <img src="images/screensApk/4.png" width="150" />
  <img src="images/screensApk/5.png" width="150" />
  <img src="images/screensApk/6.png" width="150" />
</p>

<h2 id="содержание">📜 Содержание:</h2>

* <a href="#description">Описание</a>

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Пример проверок по автоматизации</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Локальный запуск</a>

* <a href="#allure">Allure отчет</a>

* <a href="#testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Отправка результатов в Telegram-бота</a>

* <a href="#video">Видео пример запуска тестов в Browserstack</a>

-----
<a id="description"></a>
## <a name="Описание">**Описание:**</a>


**🧙️[uHabits](https://github.com/iSoron/uhabits)** — это мобильное приложение с открытым исходным кодом, предназначенное для создания и поддержания полезных привычек, помогая пользователям достигать долгосрочных целей.

- **Простой и минималистичный интерфейс**: uHabits предлагает элегантный и понятный интерфейс, удобный даже для новичков.

- **Гибкие расписания**: приложение поддерживает привычки с различной периодичностью, например, 3 раза в неделю или через день.

- **Напоминания**: возможность настраивать уведомления для каждой привычки в выбранное время дня.

- **Виджеты**: цветные виджеты позволяют отслеживать привычки прямо с главного экрана без необходимости открывать приложение.

- **Экспорт данных**: поддержка экспорта данных в CSV или SQLite для дальнейшего анализа или переноса в другие сервисы.

- **Полностью бесплатное и без рекламы**: приложение не содержит рекламы и не требует покупок внутри приложения.

- **Работает офлайн и уважает вашу конфиденциальность**: uHabits не требует подключения к интернету и не отправляет ваши данные третьим лицам.

- **Простой и минималистичный интерфейс**: uHabits предлагает элегантный и понятный интерфейс, удобный даже для новичков.

- **Гибкие расписания**: приложение поддерживает привычки с различной периодичностью, например, 3 раза в неделю или через день.

- **Напоминания**: возможность настраивать уведомления для каждой привычки в выбранное время дня.

- **Виджеты**: цветные виджеты позволяют отслеживать привычки прямо с главного экрана без необходимости открывать приложение.

- **Экспорт данных**: поддержка экспорта данных в CSV или SQLite для дальнейшего анализа или переноса в другие сервисы. 

- **Полностью бесплатное и без рекламы**: приложение не содержит рекламы и не требует покупок внутри приложения.

- **Работает офлайн и уважает вашу конфиденциальность**: uHabits не требует подключения к интернету и не отправляет ваши данные третьим лицам.

[Вернуться к оглавлению⬆️](#содержание)

<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">
<a href="https://www.jetbrains.com/idea/" target="_blank">
    <img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
</a>
<a href="https://www.java.com/" target="_blank">
    <img width="6%" title="Java" src="images/logo/Java.svg">
</a>
<a href="https://selenide.org/" target="_blank">
    <img width="5%" title="Selenide" src="images/logo/Selenide.png">
</a>
<a href="https://developer.android.com/" target="_blank">
    <img width="6%" title="Android Studio" src="images/logo/androidstudio.svg">
</a>
<a href="https://github.com/appium/appium-inspector" target="_blank">
    <img width="6%" title="Appium Inspector" src="images/logo/appium_inspector.png">
</a>
<a href="https://appium.io/" target="_blank">
    <img width="6%" title="Appium" src="images/logo/Appium.svg">
</a>
<a href="https://www.browserstack.com/" target="_blank">
    <img width="6%" title="Browser Stack" src="images/logo/browser-stack.png">
</a>
<a href="https://allurereport.org/" target="_blank">
    <img width="6%" title="Allure Report" src="images/logo/Allure.png">
</a>
<a href="https://gradle.org/" target="_blank">
    <img width="6%" title="Gradle" src="images/logo/Gradle.svg">
</a>
<a href="https://junit.org/junit5/" target="_blank">
    <img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
</a>
<a href="https://github.com/" target="_blank">
    <img width="6%" title="GitHub" src="images/logo/Github.svg">
</a>
<a href="https://www.jenkins.io/" target="_blank">
    <img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
</a>
<a href="https://telegram.org/" target="_blank">
    <img width="6%" title="Telegram" src="images/logo/Telegram.png">
</a>
</p>

* Авто-тесты для мобильного приложения Android написаны на Java.
* В качестве сборщика использовался Gradle.
* В качестве тестовых фреймворков применялись JUnit 5, Appium и Selenide.
* В качестве драйвера для Android использовался UIAutomator2.
* Тесты могли выполняться на реальном устройстве, эмуляторе, а также имели интеграцию с облачной платформой BrowserStack для мобильного тестирования.
* Для взаимодействия с API BrowserStack использовался Rest-assured.
* Для удалённого запуска был настроен Jenkins job с генерацией отчёта Allure и отправкой результатов в Telegram через бота.
* Установлена интеграция с Allure TestOps и Jira.

[Вернуться к оглавлению⬆️](#содержание)

----
<a id="cases"></a>
## **Примеры автоматизированных тест-кейсов**

### Создание привычек

- ✅ Создать привычку типа «Да/Нет»
- ✅ Создать измеримую привычку

### Онбординг

- ✅ Проверить онбординг приложения: заголовок, описание, изображение, кнопки «Пропустить» и «Далее»

### Работа с привычками

- ✅ Удалить привычку

[Вернуться к оглавлению⬆️](#содержание)

----
<a id="jenkins"></a>
## Сборка в Jenkins ([link](https://jenkins.autotests.cloud/view/QA.GURU%20students/job/c36-oPalushina-habits_mobile_tests/))
<p align="center">  
<a href="https://jenkins.autotests.cloud/view/QA.GURU%20students/job/c36-oPalushina-habits_mobile_tests/"><img src="images/screenshot/jenkins_report.png" alt="Jenkins" width="950"/></a>  
</p>

### Параметры запуска Jenkins

```bash  
clean test -DdeviceHost=remote -Duser=${BROWSERSTACK_USER} -Dkey=${BROWSERSTACK_KEY} -DremoteUrl=${REMOTE_URL} -DappName=${APP_NAME} "-Ddevice=${DEVICE_NAME}" -DosVersion=${OS_VERSION}
```

где 
- <code>user</code> - юзернейм пользователя из личного кабинета Browserstack;
- <code>key</code> - ключ пользователя из личного кабинета Browserstack;
- <code>remoteUrl</code> - удаленный адрес Browserstack;
- <code>appName</code> - идентификатор загруженного приложения из Browserstack;
- <code>device</code> - название мобильного девайса из Browserstack;
- <code>osVersion</code> - версия мобильного девайса из Browserstack.

----
<a id="console"></a>
## Запуск из терминала

**Локальный запуск**
```bash  
gradle clean test -DdeviceHost=local
```
При локальном запуске тесты запускаются на открытом устройстве в Android Studio, используются параметры из файлов connection.properties и device.properties;
при удаленном - из файлов android.properties и user.properties.

[Вернуться к оглавлению⬆️](#содержание)

----
<a id="allure"></a>
## Allure отчет ([link](https://jenkins.autotests.cloud/view/QA.GURU%20students/job/c36-oPalushina-habits_mobile_tests/5/))

**Страница отчета**
<p align="center">  
<a href="https://jenkins.autotests.cloud/view/QA.GURU%20students/job/c36-oPalushina-habits_mobile_tests/1/allure/"><img src="images/screenshot/allure_report_main.png" alt="Allure Report main" width="950"/></a>  
</p>

**Тест-кейсы**
<p align="center">  
<a href="https://jenkins.autotests.cloud/view/QA.GURU%20students/job/c36-oPalushina-habits_mobile_tests/1/allure/"><img src="images/screenshot/allure_report_cases.png" alt="Allure Report testcases" width="950"/></a>  
</p>

[Вернуться к оглавлению⬆️](#содержание)

----
<a id="testops"></a>
## Интеграция Allure TestOps ([link](https://allure.autotests.cloud/project/4950/dashboards))
<p align="center">  
<a href="https://allure.autotests.cloud/project/4932/dashboards"><img src="images/screenshot/allure_testops_main.png" alt="Allure TestOps" width="950"/></a>  
</p>

**Автоматизированные тест-кейсы**
<p align="center">  
<a href="https://allure.autotests.cloud/project/4932/dashboards"><img src="images/screenshot/allure_testops_auto.png" alt="Allure TestOps" width="950"/></a>  
</p>

**Ручные тест-кейсы**
<p align="center">  
<a href="https://allure.autotests.cloud/project/4932/dashboards"><img src="images/screenshot/allure_testops_manual.png" alt="Allure TestOps" width="950"/></a>  
</p>

[Вернуться к оглавлению⬆️](#содержание)

----
<a id="telegram"></a>
## Отправка результатов в Telegram-бота
<p align="center">  
<img src="images/screenshot/tg_bot_report.png" width="350"/> 
</p>

[Вернуться к оглавлению⬆️](#содержание)

----
<a id="video"></a>
## Видео пример запуска тестов в Browserstack
<p align="center">  
<img title="BrowserStack Video" src="images/screenshot/example_case.gif"/> 
</p>

[Вернуться к оглавлению⬆️](#содержание) 


