CREATE SCHEMA IF NOT EXISTS bell;
USE bell;

CREATE TABLE IF NOT EXISTS `Organizations` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT `Уникальный id`,
  `name` VARCHAR(100) NULL COMMENT `краткое наименование организации`,
  `inn` VARCHAR(100) NULL COMMENT `ИНН`,
  `isActive` TINYINT NULL COMMENT `является ли организация действующей`,
  `fullName` VARCHAR(100) NULL COMMENT `полное наименование оргазации`,
  `kpp` VARCHAR(100) NULL COMMENT `КПП`,
  `address` VARCHAR(100) NULL COMMENT `адрес организации`,
  `phone` VARCHAR(100) NULL COMMENT `телефон организации`,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Offices` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT `Уникальный id`,
  `orgId` INT COMMENT `id организации, которой принадлежит офис`,
  `name` VARCHAR(100) NULL COMMENT `наименование офиса`,
  `phone` VARCHAR(100) NULL COMMENT `номер телефона офиса`,
  `isActive` TINYINT NULL COMMENT `является ли офис действующим`,
  `address` VARCHAR(100) NULL COMMENT `адрес офиса`,
  PRIMARY KEY (`id`),
  CONSTRAINT `orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `Organizations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `orgId_idx` ON `Offices` (`orgId` ASC);

CREATE TABLE IF NOT EXISTS `Docs` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT `Уникальный id`,
  `code` INT NOT NULL default 0 COMMENT `code - код документа`,
  `name` VARCHAR(100) NOT NULL COMMENT `name - наименование документа`,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Countries` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT `Уникальный id`,
  `code` INT NOT NULL COMMENT `code - код страны`,
  `name` VARCHAR(100) NOT NULL COMMENT `name - название страны`,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Users` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT `уникальный идентификатор`,
  `officeId` INT NULL COMMENT `идентификатор офиса, где работает пользователь`,
  `firstName` VARCHAR(100) NULL COMMENT `имя`,
  `lastName` VARCHAR(100) NULL COMMENT `фамилия`,
  `middleName` VARCHAR(100) NULL COMMENT `отчество`,
  `position` VARCHAR(100) NULL COMMENT `должность`,
  `docId` INT NULL default 0 COMMENT `id документа из таблицы-справочника видов документов`,
  `citizenshipId` INT NULL default 0 COMMENT `id документа из таблицы-справочника стран`,
  `phone` VARCHAR(100) NULL COMMENT `номер телефона`,
  `docNumber` VARCHAR(100) NULL COMMENT `номер документа`,
  `docDate` VARCHAR(100) NULL COMMENT `дата выдачи документа`,
  `isIdentified` TINYINT NULL COMMENT `пользователь идентифицирован`,
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