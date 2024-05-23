/**
 * Title: Employee Management API
 * Description: CRUD operations for managing employees
 *
 * The version of the OpenAPI document: 1.0.0
 */
import { NgModule, ModuleWithProviders } from '@angular/core';
import { Configuration } from './configuration';
import { HttpClientModule } from '@angular/common/http';

/**
 * Module for API-related functionality.
 */
@NgModule({
  imports: [HttpClientModule],
})
export class ApiModule {

    /**
     * Provides a module with API-related services.
     * @param configurationFactory A function that returns the API configuration.
     * @returns Module with providers for the API module.
     */
    static forRoot(configurationFactory: () => Configuration): ModuleWithProviders<ApiModule> {
        return {
            ngModule: ApiModule,
            providers: [ { provide: Configuration, useFactory: configurationFactory } ]
        };
    }
}