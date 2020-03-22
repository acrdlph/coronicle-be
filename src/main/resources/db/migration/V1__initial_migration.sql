CREATE TABLE `infectedtraces` (
    `id` int not null auto_increment,
    `time` timestamp not null,
    `lat` double not null,
    `lng` double not null,
    primary key (`id`)
);
