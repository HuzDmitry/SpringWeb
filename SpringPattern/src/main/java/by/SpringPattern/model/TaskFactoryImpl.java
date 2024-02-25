package by.SpringPattern.model;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class TaskFactoryImpl implements TaskFactory{
    private final static  String[] toDo = {"TO_DO", "PLAN", "DELEGATE", "POSTPONE"};
    private final String[] name = {"Сегодня", "Завтра", "На этой неделе","В этом месяце","в это году"};
    private final String[] content = {"Потанцевать", "Протестировать новую игру",
            "Посмотреть все серии","Сделать много селфи,","Перемерить всю актуальную одежду",
            "Передвинуть мебель","Сделать планку.","Открыть для себя новую музыку","Рифмовать всё, что видите вокруг",
            "Составить и красиво оформить кроссворд","Изучить сайт, который вам нравится","Завести собственный блог",
            "Принять ванну с пеной"," Устроить спа-салон на дому"," Сделать себе массаж",
            "Начать читать какую-нибудь книгу","Попрактиковаться в йоге.","Соблазнить партнёра.",
            "Научиться медитировать.","Вздремнуть.","Провести весь день на диване","Разобраться с инструкцией к бытовым приборам",
            "Приготовить что-то интересное по рецепту","Просмотреть фотографии и видео","Обновить программное обеспечение на ноутбуке",
            "Сфотографировать ненужные вещи","Разобрать домашнюю аптечку","Начать вести личный дневник.","Составить список целей на ближайший месяц",
            "Обновить и расширить своё резюме","Обновить профиль на сайте знакомств."," Разбить мини-огород на подоконнике",
            "Сделать уборку.","Составить список плюсов и минусов задачи,","Собрать тревожный чемоданчик",
            "Научиться завязывать галстук ","Вспомнить старого друга","Поиграть с друзьями или детьми в настольные игры."};
    private final Random random = new Random();

    @Override
    public Task getTask() {
        return new TaskBuilder()
                .createTask()
                .setName(name[random.nextInt(name.length)])
                .setContent(content[random.nextInt(content.length)])
                .setToDo(toDo[random.nextInt(toDo.length)])
                .getTask();
    }

    @Override
    public Task getTask(Task task) {
        return new TaskBuilder(task)
                .setName(name[random.nextInt(name.length)])
                .setContent(content[random.nextInt(content.length)])
                .setToDo(toDo[random.nextInt(toDo.length)])
                .getTask();
    }
}
