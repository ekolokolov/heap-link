INSERT into channel
values (1, 'my'),
       (2, 'default'),
       (3, 'top');

INSERT INTO link(channel_id, name, url, description)
values (1, 'facebook', 'http://facebook.com', 'Главная фейсбука'),
       (1, 'vk', 'http://vk.com', 'Вконтакт'),
       (1, 'pikabu', 'http://pikabu.ru', 'пикабушечка'),
       (2, 'facebook', 'http://facebook.com', 'Главная фейсбука'),
       (2, 'vk', 'http://vk.com', 'Вконтакт'),
       (2, 'pikabu', 'http://pikabu.ru', 'пикабушечка');
