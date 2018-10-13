package ru.storage;

import ru.exception.StorageException;
import ru.model.Resume;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.fill;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final Integer STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected Integer sizeOfResume = 0;

    protected abstract void doSave(Integer sequence, Resume resume);

    protected abstract void doDelete(Integer index);

    @Override
    public void clear() {
        fill(storage, 0, sizeOfResume, null);
        sizeOfResume = 0;
    }

    @Override
    protected void saveEntity(Object index, Resume resume) {
        doSave((Integer) index, resume);
        sizeOfResume++;
    }

    @Override
    protected void deleteEntity(Object index, String uuid) {
        doDelete((Integer) index);
        storage[sizeOfResume + 1] = null;
        sizeOfResume--;
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected Resume doGet(Object index, String uuid) {
        return storage[(Integer) index];
    }

    @Override
    public Resume[] getAll() {
        return copyOfRange(storage, 0, sizeOfResume);
    }

    @Override
    public int size() {
        return sizeOfResume;
    }

    @Override
    protected void checkForStorageLimit(String uuid) {
        if (sizeOfResume >= STORAGE_LIMIT) {
            throw new StorageException("Массив полон", uuid);
        }
    }
}

/*

1) в классе StorageException переборщил с конструкторами: оставь только те, которые используешь!

        *Resume*
        2) не забывай форматировать код: после поля uuid, конструктора - поставь пустую строку

        *AbstractStorage*
        3) protected int sizeOfResume = 0; - эта строка тут не нужна, т.к. она нужна только для массивов. Мапа и лист не содержат заранее выделеную память, где хранились бы null, как в массиве. В мапе и листе их размер всегда равен количеству резюме. Эта переменная нужна только для массивов
        4) в данном классе имена методов, переменных - не должны содержать слово index, т.к., например в мапе нет ни каких индексов. Этот клас должен содержать максимально универсальный код. Вместо index подбери другое слово, которое подходило бы как для массивов, так и для коллекций
        5) в getIndex(resume.getUuid(), resume); передавай только один агрумент - uuid
        6) checkForStorageLimit(resume); - у листа и мапы условно нет ни какого лимита, а значит и проверять его не надо

        *MapStorage*
        7) в классе MapStorage есть потребность в том что бы делать поле resumeHashMap протектид?
        8) в названии переменной resumeHashMap не надо указывать, что она указывает на объект класса хэшМап
        9) у мапы ни каких индексов нет, у нее только key-value
        10) а почему getIndex возвращает 0?
        11) getAll() должен вернуть все резюме из мапы

        *ListStorage*
        12) см.п.7
        13) см.п.8

        14) для MapStorage и ListStorage не создал тестовых классов
        15) AbstractArrayStorageTest и прочие наследники класса AbstractStorageTest получат все его методы, поля в наследство - это значит, что в классе AbstractArrayStorageTest не надо ничего реализовывать (кроме методов, которые являются специфичнми для массивов), т.к. все уже реализовано в AbstractStorageTest (у тебя все наоборот)

        *AbstractStorageTest*
        16) private Storage arrayList = (Storage) new ArrayList<Resume>();
        инициализация поля осуществляется с помощью конструктора
        17) а почему конструктор принимает лист - AbstractStorageTest(List<Resume> arrayList), если должен принимать объект класса-наследника

        *AbstractArrayStorageTest*
        18) из этого класса перенеси все в AbstractStorageTest
        19) вместо int i = 3; напиши int i = storage.size();
        20) Resume[] array = new Resume[]{RESUME_1,RESUME_2,RESUME_3};
        Resume[] array = {RESUME_1,RESUME_2,RESUME_3}; - так короче (edited)
        */
