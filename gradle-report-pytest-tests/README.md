## Example for observing pytest results in Develocity

1. Run the following command to install `pytest`:
```shell
python3 -m venv env && source env/bin/activate && pip install pytest
```
2. Set the Develocity instance in the `settings.gradle.kts` file.
3. Run the following task which will execute python tests from the `tests` directory and use the `ImportJUnitXmlReports` task to import the results to Develocity (see `build.gradle.kts`):
```shell
./gradlew pytest
```
4. The task should fail as there are some failing tests.
