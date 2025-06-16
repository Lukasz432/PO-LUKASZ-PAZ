-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Cze 15, 2025 at 08:32 PM
-- Wersja serwera: 10.4.32-MariaDB
-- Wersja PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `steamaplikacja2`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grywbibliotece`
--

CREATE TABLE `grywbibliotece` (
  `id` int(11) NOT NULL,
  `nazwa` text NOT NULL,
  `gatunek` text NOT NULL,
  `wlasciciel_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grywsklepie`
--

CREATE TABLE `grywsklepie` (
  `id` int(11) NOT NULL,
  `nazwa` text NOT NULL,
  `gatunek` text NOT NULL,
  `cena` double NOT NULL,
  `sprzedawca_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klienci`
--

CREATE TABLE `klienci` (
  `id` int(11) NOT NULL,
  `login` text NOT NULL,
  `haslo` text NOT NULL,
  `stan_konta` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `grywbibliotece`
--
ALTER TABLE `grywbibliotece`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_wlasciciel` (`wlasciciel_id`);

--
-- Indeksy dla tabeli `grywsklepie`
--
ALTER TABLE `grywsklepie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sprzedawca` (`sprzedawca_id`);

--
-- Indeksy dla tabeli `klienci`
--
ALTER TABLE `klienci`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grywbibliotece`
--
ALTER TABLE `grywbibliotece`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `grywsklepie`
--
ALTER TABLE `grywsklepie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `klienci`
--
ALTER TABLE `klienci`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `grywbibliotece`
--
ALTER TABLE `grywbibliotece`
  ADD CONSTRAINT `fk_wlasciciel` FOREIGN KEY (`wlasciciel_id`) REFERENCES `klienci` (`id`);

--
-- Constraints for table `grywsklepie`
--
ALTER TABLE `grywsklepie`
  ADD CONSTRAINT `fk_sprzedawca` FOREIGN KEY (`sprzedawca_id`) REFERENCES `klienci` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
