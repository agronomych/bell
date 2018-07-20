/*
Генерация новой схемы БД
*/

CREATE SCHEMA IF NOT EXISTS bell;
USE bell;

/*
Генерация таблицы для организаций
name - краткое наименование организации
inn - ИНН
isActive - является ли организация действующей
fullName - полное наименование оргазации
kpp - КПП
address - адрес организации
phone - телефон организации
*/
CREATE TABLE IF NOT EXISTS `Organizations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `inn` VARCHAR(100) NULL,
  `isActive` TINYINT NULL,
  `fullName` VARCHAR(100) NULL,
  `kpp` VARCHAR(100) NULL,
  `address` VARCHAR(100) NULL,
  `phone` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


/*
Генерация таблицы для офисов
orgId - id организации, которой принадлежит офис
name - наименование офиса
phone - номер телефона офиса
isActive - является ли офис действующим
address - адрес офиса
*/
CREATE TABLE IF NOT EXISTS `Offices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orgId` INT NULL,
  `name` VARCHAR(100) NULL,
  `phone` VARCHAR(100) NULL,
  `isActive` TINYINT NULL,
  `address` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `Organizations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `orgId_idx` ON `Offices` (`orgId` ASC);


/*
Генерация таблицы-справочника для видов документов (код и наименование документа)
code - код документа
name - наименование документа
*/
CREATE TABLE IF NOT EXISTS `Docs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` INT NOT NULL default 0,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


/*
Генерация таблицы-справочника для стран (код и название страны)
code - код страны
name - название страны
*/
CREATE TABLE IF NOT EXISTS `Countries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


/*
Генерация таблицы-справочника для пользователей
id - уникальный идентификатор
officeId - идентификатор офиса, где работает пользователь
firstName - имя
lastName - фамилия
middleName - отчество
position  должность
docId - id!!! документа из таблицы-справочника видов документов
citizenshipId - id!!! документа из таблицы-справочника стран
phone - номер телефона
docNumber - номер документа
docDate - дата выдачи документа
isIdentified - пользователь идентифицирован
*/
CREATE TABLE IF NOT EXISTS `Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `officeId` INT NULL,
  `firstName` VARCHAR(100) NULL,
  `lastName` VARCHAR(100) NULL,
  `middleName` VARCHAR(100) NULL,
  `position` VARCHAR(100) NULL,
  `docId` INT NULL default 0,
  `citizenshipId` INT NULL default 0,
  `phone` VARCHAR(100) NULL,
  `docNumber` VARCHAR(100) NULL,
  `docDate` VARCHAR(100) NULL,
  `isIdentified` TINYINT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `officeId`
    FOREIGN KEY (`officeId`)
    REFERENCES `Offices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `docId`
    FOREIGN KEY (`docId`)
    REFERENCES `Docs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `citizenshipId`
    FOREIGN KEY (`citizenshipId`)
    REFERENCES `Countries` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `officeId_idx` ON `Users` (`officeId` ASC);

CREATE INDEX `docId_idx` ON `Users` (`docId` ASC);

CREATE INDEX `citizenshipId_idx` ON `Users` (`citizenshipId` ASC);