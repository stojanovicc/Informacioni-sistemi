<?php

 $message = "";
 if($_SERVER["REQUEST_METHOD"] == "GET")
			  {
				 
				 if(isset($_GET["tekst"]))
				 {
					$ime = $_GET["tekst"];
					if(strlen($ime) > 2 && strlen($ime)<20)
					{
						if($ime[0] >='A' && $ime[0]<= 'Z')
						{
							$message = "1";
						}
						else
						$message = "0";

					}
					else
						$message = "0";
					
				 }
				 else
						$message = "0";
				}
				else
						$message = "0";

echo $message;

?>