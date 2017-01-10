<?php

$password = [];
$doorId = "reyedfim";

for($counter = 0; ; $counter++) {
	if($counter % 50000 === 0) {
		echo (rand() % 540);
	}

	$hash = md5($doorId . (string) $counter);

	if(strpos($hash, '00000') === 0) {
		if(!isset($password[$hash[5]]) && $hash[5] < 8 && is_numeric($hash[5])) {
			echo "\n"."found a char".$hash[5].",".$hash[6]."\n";
			$password[$hash[5]] = $hash[6];
		}
	}

	if(sizeof($password) === 8) {
		break;
	}
}

print_r($password);
?>
