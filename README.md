![Book](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/book.png)  ![Weather](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/weather_anim.gif) 
# Contact Book And Weather Forecast
*Приложение создано в учебных целях, поэтому некоторые сходные задачи могут выполняться по-разному для отработки разных техник.* 
 ***
* [Что сделано](#about)
* [Краткое описание приложения](#brief)
* [Более подробно](#detailed)
  * [Приложение](#application)
  * [Контакты](#contacts)
  * [Прогноз погоды](#forecast)
* [Screenshots](#screenshots)

### <a name="about"></a>Что сделано. 
Приложение состоит из двух частей: книги контактов и прогноза погоды. Отступы, размеры и общее оформление, за исключением цветовой палитры) соответствует принципам Material Design, шрифты брались из com.android.support:design:28.0.0. Приложение выполнено практически без сторонних библиотек (использована только Butter Knife).

### <a name="brief"></a>Краткое описание приложения.
Приложение состоит из двух частей. 
Первая часть - книга контактов, отсортированных по первой букве фамилии. Контакт содержит имя, второе имя, отчество, фамилию, мобильный и домашний телефоны, сайт, эл.почта и адрес. Контакт можно редактировать, удалить, добавить новый  и совершить звонок на мобильный телефон (т.к. все контакты, кроме тестового, с рандомными телефонами, то звонок осуществляется только при совпадении с тестовым номером). Список контактов располагается в верхней половине экрана, информация о выбранном контакте - в нижней, размер этих окон регулируется бегунком, можно увеличить любое окно на весь экран, либо в произвольном соотношении.
Вторая часть приложения - это прогноз погоды в  Новосибирске на ближайшие 24 часа, который берется с сайта meteoservise.ru.

### <a name="detailed"></a>Более подробно:
#### <a name="application"></a>Приложение.
Приложение поддерживает англоязычную версию (по умолчанию) и русскоязычную. 
Стартовый экран разделен пополам: на одной половине картинка с книгой, на второй анимация (cell-animation) на тему погоды, при нажатии на соответствующую половину происходит запуск, соответственно, книги контактов, либо прогноза погоды.
#### <a name="contacts"></a>Контакты.
Англоязычная версия этой части приложения отличается от русскоязычной только текстом. При первой установке создается база данных (SQLiteDatabase) на 300 контактов, все данные, кроме адресов, генерируются случайным набором букв/цифр, адреса - случайная комбинация стран/городов/улиц/и т.д. и тестовый контакт с рабочим телефоном. На главном экране toolbar с кнопками "назад" и "меню" ![toolbar](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/toolbar_ru.png), горизонтальный recycler view, в котором item - буква латинского алфавита с двумя дополнительными - пробел и "all" ![alphabet1](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/alphabet_1.png) ![alphabet2](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/alphabet_2.png), при нажатии на сответствующий элемент происходит анимация свойства масштаб (AnimatorSet). Внизу экрана, а в альбомной ориентации - справа, располагается панель с кнопками (выполнены в отдельном фрагменте): ![buttons](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/button_panel_port.png). Оставшееся свободное пространство занимают два фрагмента: ContactListFragment и ContactInfoFragment. ContactListFragment  отображает содержимое базы данных по первой букве фамилии, выбранной а алфавите, ContactInfoFragment  - подробные сведения контакта, выбранного в ContactListFragment. В альбомной ориентации экрана эти фрагменты расположены слева направо, в портретной - друг над другом. В портретной ориентации слева экрана находится вертикальный SeekBar, отвечающий за то, в каких пропорциях заполнят экран фрагменты ContactListFragment и ContactInfoFragment - передвигая бегунок можно заполнить всю часть экрана, предназначенного для двух фрагментов, тем или иным фрагментом, либо выставить произвольное соотношение высот этих фрагментов.
При редактировании контакта или добавлении нового появляется новая activity с полями (заполненными при редактировании и пустыми при добавлении нового контакта) для ввода данных (с подсказками в полях и соответствующими типами клавиатур) и панель с кнопками (выполнены как часть activity, разметка ConstraintLayout) ![buttons_edit](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/buttons_edit.png), по результату действия появляется сообщение и при необходимости возврат на главную activity контактов. ![add_contact](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/toast_add_contact.png) ![save_contact](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/toast_save_contact_en.png)
При удалении контакта появляется диалоговое окно (ContactDeleteDialog) с запросом на удаление выбранного контакта ![dialog1](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/dialog_1_20.png) ![dialog2](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/dialog_2_20.png) , если никакой контакт не выбран появляется соответствующее сообщение. 
Меню содержит два пункта: добавить новый контакт (действует аналогично кнопке "добавить" на панели) и выход из приложения. ![menu](https://github.com/MyAndroidProjects/ContactBookAndWeatherForecast/blob/develop/Pictures/menu.png)
#### <a name="forecast"></a> Прогноз погоды.  
Англоязычная версия отличается от русскоязычной текстом и цветовой гаммой.  Эта часть приложения выполнена  используя ***паттерн MVP***. 
На главном экране toolbar с кнопками "назад" и "обновить" ***<вставить картику toolbar>***. Оформление выполнено при помощи card view. При запуске activity, а также при нажатии кнопки "обновить" с сайта meteoservise.ru в фоновом потоке скачивается (class WeatherForecastDataLoader extends AsyncTask) xml-файл c прогнозом погоды в Новосибирске на ближайшие 24 часа и затем парсится (используется XmlPullParserFactory). Прогноз погоды разбит на четыре временных точки - с интервалом в 6 часов, каждый такой подпрогноз отображается на card view, являющейся элементом recycler view.

### <a name="screenshots"></a>Скриншоты.
