package helpers;

public enum TopMenuItem {
   HOME("Home"), ABOUT("About"), LOGIN("Login"), ADD("Add"), CONTACTS("Contacts");

    TopMenuItem(String add) {
    }
    /**
     * TopMenuItem(String add) { ... }: Это конструктор перечисления, который принимает один аргумент типа String.
     * Каждой константе перечисления передается строковое значение, которое представляет текст пункта меню.
     * Например, для константы HOME, строковое значение равно "Home".
     */
}
