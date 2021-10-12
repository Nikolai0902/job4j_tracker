package ru.job4j.bank;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * Класс описывает работу простейщей банковской системы,
 * включает следующие дейсствия:
 * 1. Регистрация пользователя.
 * 2. Удаление пользователя из системы.
 * 3. Добавление пользователю n банковских счетов.
 * 4. Перевод денег с одного банковского счета на другой счет.
 *
 * @author NIKOLAI BUSLAEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в справочнике типа Map.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавялет в справочник пользователя.
     * Так же, создает пустой ArrayList для хранения счетов данного пользователя.
     *
     * @param user пользователь который добавляется в справочник
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет аккаунт пользователю.
     * Производится поиск пользователя по методу findByPassport.
     * Выполняется проверка, что пользователь существует.
     * Выполнется проверка, что новый аккаунт уникален.
     * Дополнительный аккаунт добавляется пользвателю.
     *
     * @param passport номер паспорта пользователя которому принадлежит аккаунт
     * @param account  новый аккаунт пользователя
     */
    public void addAccount(String passport, Account account) {
       Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    /**
     * Данный метод производит поиск пользователя по полю паспорт.
     * Поиск выполняется через цикл for в справочнике users.
     * Если поле паспорт соответствует аналогичному полю в справочнике,
     * то цикл останавливется.
     *
     * @param passport номер паспорта пользователя для поиска пользователя.
     * @return возвращает пользователя или null если пользователь не найден.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Данный метод производит поиск аккаунта по реквизитам.
     * Производится поиск пользователя по методу findByPassport.
     * Выполняется проверка, что пользователь существует.
     * Поиск выполняется через цикл for в коллекции аккаунтов пользователя.
     * Если поле реквизиты соответствует аналогичному полю в коллекции,
     * то цикл останавливется.
     *
     * @param passport  номер паспорта пользователя для поиска аккаунта.
     * @param requisite номер реквизитов пользователя для поиска аккаунта.
     * @return возвращает аккаунт или null если пользователь не найден.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
       Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод выполнет перевод суммы с аккаунта пользователя паспорта srcPassport
     * на аккаунт пользователя паспрта destPassport.
     * Производится поиск аккаунтов по методу Requisite.
     * Выполняется проверка, что реквизиты существуют и счет пользователя для списания
     * больше или равен сумме списания.
     * Если проверка true списание возможно.
     *
     * @param srcPassport   номер паспорта пользователя для списания суммы.
     * @param srcRequisite  реквизиты аккаунта пользователя для списания суммы.
     * @param destPassport  номер паспорта пользователя для зачисления суммы.
     * @param destRequisite реквизиты аккаунта пользователя для зачисления суммы.
     * @param amount        сумма списания.
     * @return возвращает true если перевод прошел успешно и false, если перевод не прошел.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite).get();
        Account destAccount = findByRequisite(destPassport, destRequisite).get();
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
